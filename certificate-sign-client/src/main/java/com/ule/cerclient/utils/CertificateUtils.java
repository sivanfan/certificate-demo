package com.ule.cerclient.utils;

import java.io.*;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Cipher;

import com.ule.cerclient.CerSignClient;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class CertificateUtils {
	public static final String KEY_STORE = "PKCS12";
	public static final String X509 = "X.509";
	private static final int MAX_ENCRYPT_BLOCK = 117;
	private static final int MAX_DECRYPT_BLOCK = 128;

	private static final String SHA1WithRSA = "SHA1WithRSA";
	private static final String RSA = "RSA";

	public static final Map<String, Object> signData = new ConcurrentHashMap<String, Object>();
	public static final String CRRECEPAY_SIGN_X509CERTIFICATE = "ULE_SIGN_X509CERTIFICATE";
	//public static final String keyPass = "123456";
	//public static final String storePass = "123456";
	public static final String alias = "ulepfx";
	//public static final String pfxFile = "I:\\cer\\wallkey.pfx";
	//public static final String pubFile = "I:\\cer\\wallkey-pub.cer";

	public static void initX509Certificate(byte[] cerContent) throws Exception {

		InputStream inputStream = null;
		try {
			CertificateFactory certificateFactory = CertificateFactory.getInstance(X509);
			inputStream = new ByteArrayInputStream(cerContent);
			X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(inputStream);
			signData.put(CRRECEPAY_SIGN_X509CERTIFICATE, x509Certificate);
		} finally {
			IOUtils.closeQuietly(inputStream);
		}
	}

	/**
	 * 获取私钥信息
	 * 
	 * @param cerContent
	 * @param keyAlias
	 * @param keyPass
	 * @param storePass
	 * @return
	 * @throws Exception
	 */
	public static PrivateKey getPrivateKey(byte[] cerContent, String keyAlias, String keyPass, String storePass)
			throws Exception {
		InputStream in = new ByteArrayInputStream(cerContent);
		KeyStore keyStore = KeyStore.getInstance(KEY_STORE);
		keyStore.load(in, storePass.toCharArray());
		PrivateKey privateKey = (PrivateKey) keyStore.getKey(keyAlias, keyPass.toCharArray());
		if (in != null) {
			IOUtils.closeQuietly(in);
		}
		return privateKey;
	}

	/**
	 * 获取公钥信息
	 * @return
	 * @throws KeyStoreException
	 * @throws IOException
	 * @throws CertificateException
	 * @throws NoSuchAlgorithmException
	 */
	public static PublicKey getPublicKey(byte[] cerContent)
			throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException {
		PublicKey publicKey = null;
		try {

			X509Certificate x509Certificate = (X509Certificate) signData.get(CRRECEPAY_SIGN_X509CERTIFICATE);
			if (x509Certificate == null) {
				initX509Certificate(cerContent);
				x509Certificate = (X509Certificate) signData.get(CRRECEPAY_SIGN_X509CERTIFICATE);
			}
			publicKey = x509Certificate.getPublicKey();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return publicKey;
	}

	/**
	 * 加密
	 * 
	 * @param requestStr
	 * @return
	 * @throws Exception
	 */
	public static String encryptContentBytes(String requestStr,byte[] cerContent) throws Exception {

		try {
			PublicKey publicKey = getPublicKey(cerContent);
			String pubKey = Base64.encodeBase64String(publicKey.getEncoded());
			byte[] content = encryptByPublicKey(requestStr.getBytes(), pubKey);
			return ConvertUtil.byte2hex(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 公钥加密
	 * 
	 * @param data
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPublicKey(byte[] data, String publicKey) throws Exception {

		byte[] keyBytes = org.apache.commons.codec.binary.Base64.decodeBase64(publicKey);
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(RSA);
		Key publicK = keyFactory.generatePublic(x509KeySpec);
		// 对数据加密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, publicK);
		int inputLen = data.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段加密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
				cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(data, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_ENCRYPT_BLOCK;
		}
		byte[] encryptedData = out.toByteArray();
		out.close();
		return encryptedData;
	}

	/**
	 * 私钥解密
	 *
	 * @param encryptedData
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPrivateKey(byte[] encryptedData, String privateKey) throws Exception {

		byte[] keyBytes = Base64.decodeBase64(privateKey);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(RSA);
		Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, privateK);
		int inputLen = encryptedData.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段解密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
				cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_DECRYPT_BLOCK;
		}
		byte[] decryptedData = out.toByteArray();
		out.close();
		return decryptedData;
	}

	/**
	 * 解密
	 * @return
	 * @throws Exception
	 */
	public static String decryptContentBytes(String responseData,byte[] cerContent,String cerPassword) throws Exception {

		try {
			byte[] responseDataBytes=ConvertUtil.hex2byte(responseData);
			PrivateKey privateKey = getPrivateKey(cerContent, alias, cerPassword, cerPassword);
			String priKey = Base64.encodeBase64String(privateKey.getEncoded());
			byte[] decryptContentBytes = decryptByPrivateKey(responseDataBytes, priKey);
			return new String(decryptContentBytes, CharEncoding.UTF_8);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 加签
	 * 
	 * @param signData
	 * @return
	 * @throws Exception
	 */
	public static String sign(String signData,byte[] cerContent,String cerPassword) throws Exception {

		InputStream in = new ByteArrayInputStream(cerContent);
		KeyStore keyStore = KeyStore.getInstance(KEY_STORE);
		keyStore.load(in, cerPassword.toCharArray());

		// 获取pfx证书别名
		Enumeration en = keyStore.aliases();
		String pName = null;
		while (en.hasMoreElements()) {
			String n = (String) en.nextElement();
			if (keyStore.isKeyEntry(n)) {
				pName = n;
			}
		}
		PrivateKey key = getPrivateKey(cerContent, pName, cerPassword, cerPassword);
		Signature signature = Signature.getInstance(SHA1WithRSA);
		signature.initSign(key);
		signature.update(signData.getBytes("UTF-8"));
		byte[] signedData = signature.sign();
		String signDate = new BASE64Encoder().encode(signedData);
		signDate = signDate.replaceAll("\r\n", "").replaceAll("\n", "");
		return signDate;
	}

	/**
	 * 验签
	 * 
	 * @return
	 * @throws Exception
	 */
	public static boolean verifySign2(String originData, String returnSignData,byte[] cerContent) throws Exception {

		PublicKey publicKey = getPublicKey(cerContent);
		Signature sign3 = Signature.getInstance(SHA1WithRSA);
		sign3.initVerify(publicKey);
		sign3.update(originData.getBytes("UTF-8"));
		boolean isVerifySign = sign3.verify(new BASE64Decoder().decodeBuffer(returnSignData));
		return isVerifySign;
	}

	/**
	 * MD5摘要算法
	 * @throws NoSuchAlgorithmException
	 * @throws Exception
	 */
	public static String MD5(String key) {
		// 十六进制转换表，0xf
		char hexDigits[] = { '7', '1', '6', '0', '4', '5', '2', '3', '8', 'D', 'F', 'B', 'C', '9', 'E', 'A' };
		try {
			byte[] btInput = key.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获取摘要密文
			byte[] md = mdInst.digest();
			// md是字节类型的数组，而MD5是一串十六进制的字符
			// 因此要把密文转换成十六进制的字符串形式，长度为32个字符
			int j = md.length;
			// 开辟一个缓冲区，用于存转换结果
			char str[] = new char[j * 2];
			int k = 0;
			// 加噪声
			for (int i = 0; i < j; i++) {
				// 逐个取摘要密文中的字符
				byte byte0 = md[i];
				// 无符号右移4位，与0xf（[1111]）取与，获得高四位
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				// 获取低四位，这也是srt[]数组长度是2*j的原因
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 根据证书路径获取证书内容的字节数组
	 * @throws IOException
	 */
	public static byte[] getContent(String filePath) throws IOException {
		File f = new File(filePath);
		FileInputStream fis = new FileInputStream( f );
		byte[] bytes = new byte[fis.available()];
		fis.read(bytes);
		fis.close();
		return bytes;
	}

	public static void main(String[] args) throws Exception {
		String originData ="spuId=618423&share_userid=123&share_mpn=13000000000&shareId=123&channel=ule";
		System.out.println("========> 原始报文："+originData);
		System.out.println("========> 加密开始");
		// 加密
		String enData = CerSignClient.encryptContent(originData,"/home/sivan/cer/wallkey-pub.cer");
		System.out.println("========> 加密 :" + enData);

		String deData = CerSignClient.decryptContent(enData,"/home/sivan/cer/wallkey.pfx","123456");
		System.out.println("========> 解密 :" + deData);

		// 加签
		/*String signData = sign(originData);
		System.out.println("========> 加签 signData:" + signData);
		boolean verifySign = verifySign2(originData, signData);
		System.out.println("========> 验签 verifySign:" + verifySign);*/
		// 摘要
		
		//System.out.println("========> MD5摘要:" + MD5(originData));
	}



}
