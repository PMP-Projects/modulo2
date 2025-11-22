package br.com.fatec.modulo2;

import br.com.fatec.modulo2.config.JwtDecoderConfig;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
@ActiveProfiles("test")
class Modulo2ApplicationTests {

    @MockitoBean
    private JwtDecoderConfig jwtDecoderConfig;

    @MockitoBean
    private ReactiveJwtDecoder reactiveJwtDecoder;

    @Mock
    private SecurityWebFilterChain securityWebFilterChain;

	@Test
	void contextLoads() {
	}

}
