package utility.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;

@Getter
@Setter
@NoArgsConstructor
public class RequestBody {
    private String objectClass;
    private Object objectInstance;

    public RequestBody(Class objectClass, Object objectInstance) {
        this.objectClass = objectClass.getName();
        this.objectInstance = objectInstance;
    }

    public String getBodyAsString() {
        return getJsonString(objectInstance);
    }

    private String getJsonString(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";

    }
}
