package com.york.user.numerology.YorkLifeCode;

/**
 * Created by GRT-EK on 2016/11/9.
 */

public class Bazi {

    // 天干五合
    String[][] merge1 = new String[][] { { "丁", "壬" }, { "戊", "癸" },
            { "甲", "己" }, { "乙", "庚" }, { "丙", "辛" } };
    // 地支六合
    String[][] merge2 = new String[][] { { "亥", "寅" }, { "卯", "戌" },
            { "子", "丑" }, { "辰", "酉" }, { "巳", "申" }, { "", "" }, { "午", "未" } };
    // 地支三合
    String[][] merge3 = new String[][] { { "亥", "卯", "未" }, { "寅", "午", "戌" },
            { "", "", "" }, { "巳", "酉", "丑" }, { "申", "子", "辰" } };
    // 地支半合
    String[][] merge4 = new String[][] { { "亥", "卯" }, { "寅", "午" },
            { "", "" }, { "巳", "酉" }, { "申", "子" }, { "卯", "未" }, { "午", "戌" },
            { "", "" }, { "酉", "丑" }, { "子", "辰" } };
    // 三會方
    String[][] merge5 = new String[][] { { "寅", "卯", "辰" }, { "巳", "午", "未" },
            { "", "", "" }, { "申", "酉", "戌" }, { "亥", "子", "丑" } };
    // 合化月份
    String[][] mergeMonth = new String[][] { { "亥", "卯", "未", "寅" },
            { "寅", "午", "戌", "巳" }, { "辰", "戌", "丑", "未" },
            { "巳", "酉", "丑", "申" }, { "申", "子", "辰", "亥" } };

    String[][] rush1 = new String[][]{{"子","午"},{"丑","未"},{"寅","申"},{"卯","酉"},{"辰","戌"},{"巳","亥"}};
    String[][] rush2 = new String[][]{{"子","未"},{"丑","午"},{"寅","巳"},{"卯","辰"},{"申","亥"},{"酉","戌"}};
    //String[][] rush3 = new String[][]{{"辰","午","酉","亥"},{"丑","未","戌"},{"子","卯","午"},{"寅","巳","申"}};
    //
    // -------------------------------------------------------------------------------------------------------------------

    // 木=0 ,火=1 ,土=2 ,金=3 ,水=4
    double[] iWuSin = new double[] { 0, 0, 0, 0, 0 };
    int[] WuSin_TanGan = new int[] { 0, 0, 1, 1, 2, 2, 3, 3, 4, 4 };
    int[][] WuSin_DiZe = new int[][] { { 4, 5, 5 }, { 2, 4, 3 }, { 0, 1, 3 },
            { 0, 5, 5 }, { 2, 0, 4 }, { 1, 3, 2 }, { 1, 2, 5 }, { 2, 1, 0 },
            { 4, 4, 2 }, { 3, 5, 5 }, { 2, 3, 1 }, { 4, 0, 5 } };
    // 喜用神:用神、喜神、忌神、仇神、閑神
    int[][] WuSin_God_Strong = new int[][] { { 1, 2, 0, 4, 3 },
            { 2, 3, 1, 0, 4 }, { 3, 4, 2, 1, 0 }, { 4, 0, 3, 2, 1 },
            { 0, 1, 4, 3, 2 } };
    int[][] WuSin_God_Weakness = new int[][] { { 0, 4, 1, 2, 3 },
            { 1, 0, 2, 3, 4 }, { 2, 1, 3, 4, 0 }, { 3, 2, 4, 0, 1 },
            { 4, 3, 0, 1, 2 } };

    String[] strWuSin = new String[] { "木", "火", "土", "金", "水" };
    int[] iTemp = new int[] { 0, 0, 0, 0, 0 };// 暫存五行數字
    String[] strTemp = new String[16];
    // 旺相休囚死表
    int[][] PowerValue = new int[][] { { 4, 1, 2, 3, 5 }, { 4, 1, 5, 2, 3 },
            { 5, 4, 1, 2, 3 }, { 5, 4, 1, 2, 3 }, { 3, 4, 5, 1, 2 },
            { 3, 5, 4, 1, 2 }, { 3, 5, 4, 1, 2 }, { 2, 3, 5, 4, 1 },
            { 1, 2, 3, 5, 4 }, { 1, 2, 3, 5, 4 }, { 1, 2, 5, 3, 4 },
            { 4, 1, 2, 3, 5 } };

    // 人元對照表
    int[][] BanChi = new int[][] { { 9, 10, 10 }, { 5, 9, 7 }, { 0, 2, 4 },
            { 1, 10, 10 }, { 4, 1, 9 }, { 2, 6, 4 }, { 3, 5, 10 }, { 5, 3, 1 },
            { 6, 8, 4 }, { 7, 10, 10 }, { 4, 7, 3 }, { 8, 0, 10 } };
    //夫妻對照表
    int[] MaleTable = new int[]{5, 4, 7, 6, 9, 8, 1, 0, 3, 2};
    int[] FemaleTable = new int[]{7, 6, 9, 8, 1, 0, 3, 2, 5, 4};
    int[] MonthAdd = new int[] { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273,
            304, 334 };
    int[] MonthDize = new int[] { 6, 35, 65, 96, 126, 158, 189, 221, 252, 282,
            313, 342 };

    String[][] SiSn = new String[][] {
            { "比肩", "劫財", "食神", "傷官", "偏財", "正財", "七殺", "正官", "偏印", "正印", "" },
            { "劫財", "比肩", "傷官", "食神", "正財", "偏財", "正官", "七殺", "正印", "偏印", "" },
            { "偏印", "正印", "比肩", "劫財", "食神", "傷官", "偏財", "正財", "七殺", "正官", "" },
            { "正印", "偏印", "劫財", "比肩", "傷官", "食神", "正財", "偏財", "正官", "七殺", "" },
            { "七殺", "正官", "偏印", "正印", "比肩", "劫財", "食神", "傷官", "偏財", "正財", "" },
            { "正官", "七殺", "正印", "偏印", "劫財", "比肩", "傷官", "食神", "正財", "偏財", "" },
            { "偏財", "正財", "七殺", "正官", "偏印", "正印", "比肩", "劫財", "食神", "傷官", "" },
            { "正財", "偏財", "正官", "七殺", "正印", "偏印", "劫財", "比肩", "傷官", "食神", "" },
            { "食神", "傷官", "偏財", "正財", "七殺", "正官", "偏印", "正印", "比肩", "劫財", "" },
            { "傷官", "食神", "正財", "偏財", "正官", "七殺", "正印", "偏印", "劫財", "比肩", "" } };

    String[][] ChanSan = new String[][] {
            { "亥", "子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌" },
            { "午", "巳", "辰", "卯", "寅", "丑", "子", "亥", "戌", "酉", "申", "未" },
            { "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥", "子", "丑" },
            { "酉", "申", "未", "午", "巳", "辰", "卯", "寅", "丑", "子", "亥", "戌" },
            { "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥", "子", "丑" },
            { "酉", "申", "未", "午", "巳", "辰", "卯", "寅", "丑", "子", "亥", "戌" },
            { "巳", "午", "未", "申", "酉", "戌", "亥", "子", "丑", "寅", "卯", "辰" },
            { "子", "亥", "戌", "酉", "申", "未", "午", "巳", "辰", "卯", "寅", "丑" },
            { "申", "酉", "戌", "亥", "子", "丑", "寅", "卯", "辰", "巳", "午", "未" },
            { "卯", "寅", "丑", "子", "亥", "戌", "酉", "申", "未", "午", "巳", "辰" } };

    String[] ChanSan_12 = new String[] { "長生", "沐浴", "冠帶", "臨官", "帝旺", "衰",
            "病", "死", "墓", "絕", "胎", "養" };

    // 大運流年
    int[][] GoodYear = new int[][] { { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 },
            { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 } };

    // 天德貴人表
    String[] GS1 = new String[] { "巳", "庚", "丁", "申", "壬", "辛", "亥", "甲", "癸",
            "寅", "丙", "乙", "巳" };
    // 月德貴人表
    String[] GS2 = new String[] { "壬", "庚", "丙", "甲" };
    // 將星表
    String[] GS3 = new String[] { "子", "酉", "午", "卯" };
    // 文昌表
    String[] GS4 = new String[] { "巳", "午", "申", "酉", "申", "酉", "亥", "子", "寅",
            "卯" };
    // 華蓋表
    String[] GS5 = new String[] { "辰", "丑", "戌", "未" };
    // 驛馬表
    String[] GS6 = new String[] { "寅", "亥", "申", "巳" };
    // 桃花表
    String[] GS7 = new String[] { "酉", "午", "卯", "子" };
    // 干祿表
    String[] GS8 = new String[] { "寅", "卯", "巳", "午", "巳", "午", "申", "酉", "亥",
            "子" };
    // 陰陽刃
    String[] GS9 = new String[] { "卯", "辰", "午", "未", "午", "未", "酉", "戌", "子",
            "丑" };
    // 紅豔表
    String[] GS10 = new String[] { "午", "午", "寅", "未", "辰", "辰", "戌", "酉", "子",
            "申" };
    // 孤辰
    String[] GS11 = new String[] { "寅", "寅", "巳", "巳", "巳", "申", "申", "申", "亥",
            "亥", "亥", "寅" };
    // 寡宿
    String[] GS12 = new String[] { "戌", "戌", "丑", "丑", "丑", "辰", "辰", "辰", "未",
            "未", "未", "戌" };
    // 財庫
    String[] GS13 = new String[] { "辰", "辰", "丑", "丑", "辰", "辰", "未", "未", "戌",
            "戌" };
    // 天乙貴人
    String[][] GS14 = new String[][] { { "丑", "未" }, { "子", "申" },
            { "亥", "酉" }, { "亥", "酉" }, { "丑", "未" }, { "子", "申" },
            { "午", "寅" }, { "午", "寅" }, { "卯", "巳" }, { "卯", "巳" } };
    private int[] mLifeCode;
    private int[][] mElement = new int[][]{{0,0,0},{1,1}};

    public Bazi(int[]  lifeCode) {
        this.mLifeCode = lifeCode;
    }

    /**
     *
     * @param singleDeqi
     * @return
     */
    public int[] getElement(int singleDeqi){
        return mElement[singleDeqi];
    }


}