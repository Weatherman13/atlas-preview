package ru.thirteenth.atlas.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.thirteenth.atlas.model.Language;
import ru.thirteenth.atlas.exception.UserLanguageInvalidTypeException;

import javax.persistence.*;

import java.util.Locale;
import java.util.ResourceBundle;

import static ru.thirteenth.atlas.model.State.START;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_atlas")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "telegramId")
    private long telegramId;
    @Column(name = "state")
    private String state;
    @Column(name = "username")
    private String username;

    @Column(name = "language")
    private String language;

    public User(long telegramId, String state, String username, String language) {
        this.telegramId = telegramId;
        this.state = state;
        this.username = username;
        this.language = language;
    }

    public static User telegramUserMapper(org.telegram.telegrambots.meta.api.objects.User telegramUser) {

        var telegramId = telegramUser.getId();
        var username = telegramUser.getUserName();

        return new User(telegramId, START.toString(), username, Language.RU.toString() );
    }

    public ResourceBundle getResourceBundle() {

        if (!this.getLanguage().equals(null) &&
                (this.getLanguage().toString().toLowerCase().equals("en") ||
                        this.getLanguage().toString().toLowerCase().equals("ru"))) {

            var locale = new Locale(this.getLanguage().toString());
            return ResourceBundle.getBundle("ru.thirteenth.atlas.resources.resource",locale);
        }
        throw new UserLanguageInvalidTypeException("The user's language type is invalid");
    }
}
