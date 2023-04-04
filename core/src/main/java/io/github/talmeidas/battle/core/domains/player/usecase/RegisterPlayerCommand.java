package io.github.talmeidas.battle.core.domains.player.usecase;

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
public class RegisterPlayerCommand extends SelfValidating<RegisterPlayerCommand> implements Serializable {

    @Serial
    private static final long serialVersionUID = -839218396070000776L;

    @NotBlank(message = "validation.player.name.blank")
    private final String name;

    @NotBlank(message = "validation.player.email.blank")
    private final String email;

    public RegisterPlayerCommand(final String email, final String name) {
        this.email = email;
        this.name = name;
        this.validateSelf();
    }
}
