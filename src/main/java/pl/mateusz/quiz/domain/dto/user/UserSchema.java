
package user;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * A representation of a user
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "user_id",
    "user_login",
    "user_password"
})
public class UserSchema {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("user_id")
    private String userId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("user_login")
    private String userLogin;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("user_password")
    private String userPassword;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("user_id")
    public String getUserId() {
        return userId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("user_id")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("user_login")
    public String getUserLogin() {
        return userLogin;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("user_login")
    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("user_password")
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("user_password")
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(UserSchema.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("userId");
        sb.append('=');
        sb.append(((this.userId == null)?"<null>":this.userId));
        sb.append(',');
        sb.append("userLogin");
        sb.append('=');
        sb.append(((this.userLogin == null)?"<null>":this.userLogin));
        sb.append(',');
        sb.append("userPassword");
        sb.append('=');
        sb.append(((this.userPassword == null)?"<null>":this.userPassword));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.userLogin == null)? 0 :this.userLogin.hashCode()));
        result = ((result* 31)+((this.userPassword == null)? 0 :this.userPassword.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.userId == null)? 0 :this.userId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UserSchema) == false) {
            return false;
        }
        UserSchema rhs = ((UserSchema) other);
        return (((((this.userLogin == rhs.userLogin)||((this.userLogin!= null)&&this.userLogin.equals(rhs.userLogin)))&&((this.userPassword == rhs.userPassword)||((this.userPassword!= null)&&this.userPassword.equals(rhs.userPassword))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.userId == rhs.userId)||((this.userId!= null)&&this.userId.equals(rhs.userId))));
    }

}
