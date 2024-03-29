package br.com.dbc.vemser.pessoaapi.security;

import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.service.UsuarioService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.Date;


@Service
@RequiredArgsConstructor
public class TokenService {
    private final UsuarioService usuarioService;
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expiration;


    public String getToken(UsuarioEntity usuarioEntity) {
        Date date = new Date();
        Date dateExp = new Date(date.getTime() + Long.valueOf(expiration));
        String token = Jwts.builder()
                .setIssuer("pessoa-api")
                .claim(Claims.ID, usuarioEntity.getIdUsuario())
                .setIssuedAt(date)
                .setExpiration(dateExp)
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
        return TokenAuthenticationFilter.BEARER + token;
    }

    public UsernamePasswordAuthenticationToken isValid(String token) {
        if (token == null){
            return null;
        }
        Claims body = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        Integer idUsuario = body.get(Claims.ID,Integer.class);
        if (idUsuario != null){
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(idUsuario,null, Collections.emptyList());

            return usernamePasswordAuthenticationToken;
        }
        return null;
    }
}
