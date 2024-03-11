package by.zemich.resourceserver.service.web;

import by.zemich.resourceserver.service.api.Access;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
@RequestMapping("/secret")
public class SecretController {

    private final Access accessService;

    public SecretController(Access access) {
        this.accessService = access;
    }

    @GetMapping()
    //@RolesAllowed(value = "USER")
    public ResponseEntity<String> getSecret() {
        return ResponseEntity.ok(accessService.getSecretCode());
    }




}
