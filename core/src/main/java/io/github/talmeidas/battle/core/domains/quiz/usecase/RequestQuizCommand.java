package io.github.talmeidas.battle.core.domains.quiz.usecase;

import io.github.talmeidas.battle.core.common.validation.SelfValidating;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;

@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@ToString
public class RequestQuizCommand extends SelfValidating<RequestQuizCommand> implements Serializable {

    @Serial private static final long serialVersionUID = 2442972304512536452L;

    @NotBlank(message = "validation.player.email.blank")
    private final String playerEmail;

    @NotBlank(message = "validation.player.name.blank")
    private final String playerName;

    public RequestQuizCommand(final String playerEmail, final String playerName) {
        this.playerEmail = playerEmail;
        this.playerName = playerName;
        this.validateSelf();
    }
}
