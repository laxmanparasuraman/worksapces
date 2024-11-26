import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

public class TESTJwtExample {
    public static void main(String[] args) {
        String jwtToken = "<your-jwt-token>";
       // SecretKey key = Keys.hmacShaKeyFor(jwtToken.getBytes());

        /*Claims claims = Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();

        System.out.println("Claims: " + claims);*/
    }
}
