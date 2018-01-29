package com.blue.codec.utils.common;

import org.junit.Test;

/**
 * @author shenjie
 * @version v1.0
 * @Description
 * @Date: Create in 14:24 2018/1/29
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

public class BytesUtilTestCase {
    @Test
    public void testBcdStr2Str(){
        String bcdStr = "2e4e455401000200000000000000020003010003000101b901000053797" +
                "374656d2e52756e74696d652e52656d6f74696e672e52656d6f74696e674578636570" +
                "74696f6e3a2054435020e4bfa1e98193e58d8fe8aeaee586b2e7aa813a20e5ba94e4b8ba" +
                "e68aa5e5a4b4e380820d0a202020e59ca82053797374656d2e52756e74696d652e" +
                "52656d6f74696e672e4368616e6e656c732e5463702e546370536f636b657448616e" +
                "646c65722e5265616456657273696f6e416e644f7065726174696f6e2855496e743136" +
                "26206f7065726174696f6e290d0a202020e59ca82053797374656d2e52756e74696d652e52656d6f7" +
                "4696e672e4368616e6e656c732e5463702e546370536572766572536f636b6" +
                "57448616e646c65722e526561644865616465727328290d0a202020e59" +
                "ca82053797374656d2e52756e74696d652e52656d6f74696e672e4368616e6" +
                "e656c732e5463702e5463705365727665725472616e73706f727453696e6b2e536572766963655265717" +
                "5657374284f626a656374207374617465290d0a202020e59ca82053797374656d2e52756e74696d652e52" +
                "656d6f74696e672e4368616e6e656c732e536f636b657448616e646c65722e50726f63657373526571756573744e6f7728290500000000";
        String result = BytesUtil.bcdStr2Str(bcdStr);
        System.out.println(result);
    }
}