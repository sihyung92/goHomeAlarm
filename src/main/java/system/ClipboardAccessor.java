package system;

import java.awt.datatransfer.*;
import java.awt.*;
import java.io.IOException;

public class ClipboardAccessor {
    final private Clipboard clipboard;

    public ClipboardAccessor() {
        this.clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    public void copy(String message) {
        StringSelection stringData = new StringSelection(message);
        clipboard.setContents(stringData, stringData);
    }

    public String paste() throws IOException, UnsupportedFlavorException {
        Transferable copiedString = clipboard.getContents(null);

        if (copiedString.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            return (String) copiedString.getTransferData(DataFlavor.stringFlavor);
        }
        return "";
    }
}
