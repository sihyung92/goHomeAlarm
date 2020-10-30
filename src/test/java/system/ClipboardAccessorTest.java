package system;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class ClipboardAccessorTest {
    private static ClipboardAccessor clipboardAccessor;

    @BeforeAll
    static void setUp(){
        clipboardAccessor = new ClipboardAccessor();
    }

    @ParameterizedTest
    @DisplayName("복사와 붙여넣기가 되는지 확인한다.")
    @ValueSource(strings = {"TESTDATA","한글복사해보기","12345678","test test test"})
    public void copyAndPaste(String testString) throws IOException, UnsupportedFlavorException {
        clipboardAccessor.copy(testString);
        assertThat(clipboardAccessor.paste()).isEqualTo(testString);
    }
}
