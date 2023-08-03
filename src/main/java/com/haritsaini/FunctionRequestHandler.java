package com.haritsaini;
import com.haritsaini.dtos.PropertyDto;
import io.micronaut.function.aws.MicronautRequestHandler;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import io.micronaut.json.JsonMapper;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import jakarta.inject.Inject;
import java.util.Collections;
import java.util.List;

public class FunctionRequestHandler extends MicronautRequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    @Inject
    JsonMapper objectMapper;

    @Override
    public APIGatewayProxyResponseEvent execute(APIGatewayProxyRequestEvent input) {
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        try {
            PropertyDto propertyDto = PropertyDto.builder()
                    .id(1)
                    .buyers(List.of("Vikas Kumar,Harit Saini"))
                    .sellers(List.of("Hemant Kumar","Balram"))
                    .refId("3OY32YYHH78")
                    .build();
            PropertyDto propertyDto2 = PropertyDto.builder()
                    .id(13)
                    .buyers(List.of("Virender Kumar,Rajesh Goel"))
                    .sellers(List.of("Deepak Kumar","Balram"))
                    .refId("GGHU7889")
                    .build();

            String json = new String(objectMapper.writeValueAsBytes(List.of(propertyDto2,propertyDto)));
            response.setStatusCode(200);
            response.setBody(json);
        } catch (IOException e) {
            response.setStatusCode(500);
        }
        return response;
    }
}
