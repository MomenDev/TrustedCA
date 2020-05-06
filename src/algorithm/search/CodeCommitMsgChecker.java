package algorithm.search;

import java.util.*;

/**
 * @author chenjian
 * @date 2020/05/07
 * description:用于检查代码提交信息是否符合规范
 * history
 * V1.0:初始版本
 **/
public class CodeCommitMsgChecker {
    /**
     * 合法关键字集合，超出范围的字符将不能识别
     */
    public static final String[] KEY_WORDS_ALL = new String[]{
            "TicketNo:", "DefectNo:", "Description:", "Tag:", "Team:",
    };
    public static final String[] KEY_WORDS_REQUIRED = new String[]{
            "TicketNo:", "DefectNo:", "Description:",
    };

    /**
     * 禁止使用冒号作为关键字
     */
    public final String[] mIllegalSynbols = new String[]{
            "："
    };

    /**
     * 存储非法字符集合
     */
    public final Set<String> mIllegalSymbolSet = new HashSet();

    public CodeCommitMsgChecker() {
        for (String invalid : mIllegalSynbols) {
            mIllegalSymbolSet.add(invalid);
        }
    }

    /**
     * 检查代码提交的日志是否符合代码规范
     *
     * @param commitMsg 提交代码日志
     * @return 如果符合规范则返回true，否则返回false
     */
    public boolean CodeCommitMsgCheck(String commitMsg) {
        //用于存储每个关键对应的数据内容
        HashMap<String, String> valMap = new HashMap<String, String>(KEY_WORDS_ALL.length);

        if (commitMsg == null || commitMsg.length() <= 0) {
            return false;
        }
        //如果存在非法字符则不符合规范
        for (String illegal : mIllegalSymbolSet) {
            if (commitMsg.indexOf(illegal) >= 0) {
                System.out.println("[Contains illegal symbol]\n" + illegal);
                return false;
            }
        }

        int[][] searchretall = multiSearch(commitMsg, KEY_WORDS_ALL);
        //如果存在重复的关键字则不符合规范
        for (int i = 0; i < searchretall.length; i++) {
            if (searchretall[i].length >= 2) {
                System.out.println("[multi key words]\n" + KEY_WORDS_ALL[i]);
                return false;
            }
        }
        int[][] searchretRequired = multiSearch(commitMsg, KEY_WORDS_REQUIRED);
        //如果缺少必选字段也不符合规范
        for (int i = 0; i < searchretRequired.length; i++) {
            if (searchretRequired[i].length <= 0) {
                System.out.println("[key word missing]\n" + KEY_WORDS_REQUIRED[i]);
                return false;
            }
        }


        return true;
    }

    private int[] searchAllStartpos(String src, String keyword) {
        List<Integer> res = new ArrayList<>();
        if (keyword.length() == 0) {
            return new int[0];
        }
        int index = src.indexOf(keyword);
        while (index != -1) {
            res.add(index);
            index = src.indexOf(keyword, index + 1);
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    /**
     * 在src字符串中查找出所有subkeys关键字的开始位置
     *
     * @param src      字符串源
     * @param keywords 被查找的关键字
     * @return 返回每个关键字对应的起始位置，如果某个关键字没有查询到则为空数组
     */
    public int[][] multiSearch(String src, String[] keywords) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < keywords.length; i++) {
            res.add(searchAllStartpos(src, keywords[i]));
        }
        return res.toArray(new int[0][]);
    }
}
