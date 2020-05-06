package test.algorithm.search;

import algorithm.search.CodeCommitMsgChecker;
import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author chenjian
 * @date 2020/05/07
 * description:
 **/
@RunWith(Parameterized.class)
public class CodeCommitMsgTest {

    @Parameterized.Parameters
    public static Collection<Pair<String, Boolean>> data() {
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < CodeCommitMsgChecker.KEY_WORDS_ALL.length; i++) {
            sb1.append(CodeCommitMsgChecker.KEY_WORDS_ALL[i]);
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < CodeCommitMsgChecker.KEY_WORDS_REQUIRED.length; i++) {
            sb2.append(CodeCommitMsgChecker.KEY_WORDS_REQUIRED[i]);
        }

        Pair<String, Boolean>[] ret = new Pair[]{
                new Pair("test", Boolean.FALSE),
                new Pair("", Boolean.FALSE),
                new Pair(null, Boolean.FALSE),
                new Pair("：", Boolean.FALSE),
                new Pair("TicketNo：", Boolean.FALSE),
                new Pair(sb1.toString(), Boolean.TRUE),
                new Pair(sb2.toString(), Boolean.TRUE),
        };
        return Arrays.asList(ret);
    }

    private String fInput;
    private Boolean fExpected;

    public CodeCommitMsgTest(Pair<String, Boolean> fdata) {
        this.fInput = fdata.getKey();
        this.fExpected = fdata.getValue();
    }

    @Test
    public void codeCommitMsgCheck2() {
        CodeCommitMsgChecker checker = new CodeCommitMsgChecker();
        Assert.assertEquals(fExpected, checker.CodeCommitMsgCheck(fInput));
    }
}