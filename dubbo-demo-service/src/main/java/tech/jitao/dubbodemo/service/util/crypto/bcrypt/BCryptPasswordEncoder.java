package tech.jitao.dubbodemo.service.util.crypto.bcrypt;

import com.google.common.base.Strings;
import tech.jitao.dubbodemo.service.util.crypto.password.PasswordEncoder;

import java.util.regex.Pattern;

public class BCryptPasswordEncoder implements PasswordEncoder {
    private static final Pattern BCRYPT_PATTERN = Pattern.compile("\\A\\$2(a|y|b)?\\$(\\d\\d)\\$[./0-9A-Za-z]{53}");
    private static final int STRENGTH = 10;

    @Override
    public String encode(CharSequence rawPassword) {
        String salt = BCrypt.gensalt("$2a", STRENGTH);

        return BCrypt.hashpw(rawPassword.toString(), salt);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (Strings.isNullOrEmpty(encodedPassword)) {
            return false;
        }

        if (!BCRYPT_PATTERN.matcher(encodedPassword).matches()) {
            return false;
        }

        return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
    }
}
