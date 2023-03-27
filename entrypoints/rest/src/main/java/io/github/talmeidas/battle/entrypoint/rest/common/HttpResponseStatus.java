package io.github.talmeidas.battle.entrypoint.rest.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HttpResponseStatus implements Serializable {

    @Serial
    private static final long serialVersionUID = -6858852262094487391L;

    private LocalDateTime timestamp;
    private long status;
    private String error;
    private String message;
    private String path;
}
