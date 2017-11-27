package com.dh.springboot;

import org.springframework.stereotype.Service;

@Service
public class TextServiceImpl implements TextService {
    private final static String UP_CHARS = "aeiouáéěíóúůAEIOUÁÉĚÍÓÚŮ";

    @Override
    public String customReverse(String text) {
        if (text == null) {
            return text;
        }

        if (text.length() == 0) {
            return text;
        }

        StringBuilder sb = new StringBuilder();
        char prev = '.';
        char ch;

        int last = 0;
        int i = text.length() - 1;

        while (0 <= i) {
            ch = text.charAt(i);

            if (ch != ' ' || prev != ' ') {
                if (UP_CHARS.indexOf(text.charAt(last)) != -1) {
                    ch = Character.toUpperCase(ch);
                } else {
                    ch = Character.toLowerCase(ch);
                }
                sb.append(ch);
                last++;
            }
            prev = ch;
            i--;
        }
        return sb.toString();
    }
}
