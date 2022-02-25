import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.AuthorizationValue;
import io.swagger.v3.parser.core.models.ParseOptions;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ApiTest {

    @Test
    void testIfOpenApiFileIsParsable() {
        List<AuthorizationValue> authorizationValues = List.of();
        String url = "openapi-working.yaml";
        SwaggerParseResult swaggerParseResult = new OpenAPIV3Parser().readLocation(url, authorizationValues, getParseOptions());

        Assertions.assertThat(swaggerParseResult).isNotNull();
        Assertions.assertThat(swaggerParseResult.getMessages()).isEmpty();
    }

    private ParseOptions getParseOptions() {
        ParseOptions options = new ParseOptions();
        options.setResolve(true);
        options.setResolveCombinators(false);
        options.setResolveFully(true);
        return options;
    }
}
