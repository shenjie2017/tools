package com.blue.codec.utils.common;

import javax.imageio.stream.FileImageOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author shenjie
 * @version v1.0
 * @Description
 * @Date: Create in 13:58 2018/1/29
 * @Modifide By:
 **/

//      ┏┛ ┻━━━━━┛ ┻┓
//      ┃　　　　　　 ┃
//      ┃　　　━　　　┃
//      ┃　┳┛　  ┗┳　┃
//      ┃　　　　　　 ┃
//      ┃　　　┻　　　┃
//      ┃　　　　　　 ┃
//      ┗━┓　　　┏━━━┛
//        ┃　　　┃   神兽保佑
//        ┃　　　┃   代码无BUG！
//        ┃　　　┗━━━━━━━━━┓
//        ┃　　　　　　　    ┣┓
//        ┃　　　　         ┏┛
//        ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
//          ┃ ┫ ┫   ┃ ┫ ┫
//          ┗━┻━┛   ┗━┻━┛

public class BytesUtil {

    /**
     * @Description: byte转int
     * @param :num : 127 ~ -128
     * @return byte
     * @throws Exception
     */
    public static byte int2Byte(int num) {
        return (byte) num;
    }

    /**
     * 将8字节整数变成字节数组
     *
     * @param value
     * @return
     */
    public static byte[] long2Bytes(long value) {
        byte[] b = new byte[8];
        for (int i = 0; i < 8; i++) {
            int offset = (b.length - 1 - i) * 8;
            b[i] = (byte) ((value >>> offset) & 0xFF);
        }
        return b;
    }

    /**
     * 将object序列化成字节数组
     * @param obj
     * @return
     */
    public static byte[] object2Bytes(Object obj) {
        byte[] bytes = null;
        try {
            // object to bytearray
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(obj);

            bytes = bo.toByteArray();

            bo.close();
            oo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * 将4个字节的byte数组变成整数
     *
     * @param  b
     * @return
     */
    public static int bytes2Int4(byte[] b) {
        int s = 0;
        s = ((b[0] & 0xff) << 24 | (b[1] & 0xff) << 16 | (b[2] & 0xff) << 8 | (b[3] & 0xff));
        return s;
    }

    /**
     * 将两个字节的byte数组变成整数
     */
    public static int bytes2Int2(byte b[]) {
        int s = 0;
        s = ((b[0] & 0xff) << 8 | (b[1] & 0xff));
        return s;
    }

    public static short bytes2Short(byte[] bytes) {
        int length = bytes.length;
        short intValue = 0;
        for (int i = 0; i < length; i++) {
            intValue <<= 8;
            intValue |= (bytes[i] & 0xff);
        }
        return intValue;
    }

    /**
     *
     * @Description: 将十进制转为为16机制 例如：new byte[]{1,2,3,17}转化为01020311
     * @param :args
     * @return
     * @throws Exception
     */
    public static String bcd2Str(byte[] bytes) {
        StringBuffer temp = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            temp.append((byte) ((bytes[i] & 0xf0) >>> 4));
            temp.append((byte) (bytes[i] & 0x0f));
        }

        // 表示把第一位的0忽略 例如：1返回1 19返回13
        return temp.toString().substring(0, 1).equalsIgnoreCase("0") ? temp.toString().substring(1) : temp.toString();

    }

    /**
     * 把10进制变成16进制
     *
     * @param b 传过来的是十进制
     * @return 返回的是16进制
     */
    public static String bcd2Str(byte b) {
        StringBuffer temp = new StringBuffer(2);

        temp.append((byte) ((b & 0xf0) >>> 4));
        temp.append((byte) (b & 0x0f));

        return temp.toString().substring(0, 1).equalsIgnoreCase("0") ? temp.toString().substring(1) : temp.toString();
    }

    /**
     * @Description: 字节转化为Long类型
     * @param :args
     * @return
     * @throws Exception
     */
    public static long bytes2Long(byte[] bytes) {
        int length = bytes.length;
        long longValue = 0;
        for (int i = 0; i < bytes.length; i++) {
            longValue <<= 8;
            longValue |= (bytes[i] & 0xff);
        }
        return longValue;
    }


    /**
     * * 把16进制字符串转化成2进制字符串 * @param b * @return
     */
    public static String hexStr2BinaryStr(String hexString) {
        if (hexString == null || hexString.length() % 2 != 0) {
            return null;
        }
        String bString = "", tmp;
        for (int i = 0; i < hexString.length(); i++) {
            tmp = "0000" + Integer.toBinaryString(Integer.parseInt(hexString.substring(i, i + 1), 16));
            bString += tmp.substring(tmp.length() - 4);
        }
        return bString;
    }

    /**
     * @Description 字符串边字节数组 8421码
     */
    public static byte[] str2Bcd(String asc) {
        int len = asc.length();
        int mod = len % 2;

        if (mod != 0) {
            asc = "0" + asc;
            len = asc.length();
        }

        byte abt[] = null;
        if (len >= 2) {
            len = len / 2;
        }

        byte bbt[] = new byte[len];
        abt = asc.getBytes();
        int j, k;

        for (int p = 0; p < asc.length() / 2; p++) {
            if ((abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {
                j = abt[2 * p] - '0';
            } else if ((abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {
                j = abt[2 * p] - 'a' + 0x0a;
            } else {
                j = abt[2 * p] - 'A' + 0x0a;
            }

            if ((abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {
                k = abt[2 * p + 1] - '0';
            } else if ((abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {
                k = abt[2 * p + 1] - 'a' + 0x0a;
            } else {
                k = abt[2 * p + 1] - 'A' + 0x0a;
            }

            int a = (j << 4) + k;
            byte b = (byte) a;
            bbt[p] = b;
        }
        return bbt;
    }

    /**
     * @Description int类型转换成一个2长度的byte数组
     *
     */
    public static byte[] int2Bytes(int value) {
        byte[] ret = new byte[2];
        ret[1] = (byte) (value & 0xFF);// 低位
        value = value >> 8;
        ret[0] = (byte) (value & 0xFF);// 高位
        return ret;
    }

    /**
     * @Description int类型转换成一个4长度的byte数组
     *
     */
    public static byte[] int2Bytes4(int value) {
        int temp = value;
        byte[] b = new byte[4];
        for (int i = 0; i < b.length; i++) {
            b[i] = new Integer(temp & 0xff).byteValue();
            temp = temp >>> 8;
        }
        return b;
    }

    /**
     * @Description: 字符串转化为标准日期格式
     * @param :字符串
     * @return: 日期类型
     * @throws Exception
     */
    public static Date str2Date(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
        Date dates = null;
        try {
            dates = format.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dates;
    }

    // 字符串转换为ASCII
    public static String str2Ascii(String value) {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1) {
                sbu.append((int) chars[i]).append(",");
            } else {
                sbu.append((int) chars[i]);
            }
        }
        return sbu.toString();
    }

    /**
     * @Description: 格式化时间
     * @param :args
     * @return
     * @throws Exception
     */
    public static String date2Str(Date date) {
        // 时间
        // 格式化时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sTime = format.format(date);
        return sTime;
    }




    public static void byte2Image(byte[] data, String path) {
        if (data.length < 3 || path.equals("")) {
            return;
        }
        try {
            FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String bcdStr2Str(String bcdStr){
        byte[] bytes = str2Bcd(bcdStr);
        return new String(bytes);
    }

}