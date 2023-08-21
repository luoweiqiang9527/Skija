package io.github.humbleui.skija.test.paragraph;

import static io.github.humbleui.skija.test.runner.TestRunner.*;

import io.github.humbleui.skija.paragraph.TextStyle;
import io.github.humbleui.skija.paragraph.TextStyleAttribute;
import io.github.humbleui.skija.test.*;
import io.github.humbleui.skija.test.paragraph.*;
import io.github.humbleui.skija.test.runner.*;

public class TextStyleTest implements Executable {
    @Override
    public void execute() throws Exception {
        assertEquals(new TextStyle(), new TextStyle());

        try (var ts1 = new TextStyle();
             var ts2 = new TextStyle();)
        {
            for (var attr: new TextStyleAttribute[] {
                TextStyleAttribute.ALL_ATTRIBUTES,
                TextStyleAttribute.FONT,
                TextStyleAttribute.FOREGROUND,
                TextStyleAttribute.BACKGROUND,
                TextStyleAttribute.SHADOW,
                TextStyleAttribute.DECORATIONS,
                TextStyleAttribute.LETTER_SPACING,
                TextStyleAttribute.WORD_SPACING,
                TextStyleAttribute.FONT_EXACT})
            {
                pushStack(attr.toString());
                assertEquals(true, ts1.equals(attr, ts2));
                assertEquals(true, ts2.equals(attr, ts1));
                popStack();
            }
        }

        assertEquals(false, new TextStyle().setColor(0xFFcc3300).equals(TextStyleAttribute.ALL_ATTRIBUTES, new TextStyle().setColor(0xFF00cc33)));
        assertEquals(true, new TextStyle().setColor(0xFFcc3300).equals(TextStyleAttribute.BACKGROUND, new TextStyle().setColor(0xFF00cc33)));
    }
}
