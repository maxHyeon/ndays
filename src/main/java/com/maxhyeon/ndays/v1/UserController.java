package com.maxhyeon.ndays.v1;

import com.maxhyeon.ndays.entity.Users;
import com.maxhyeon.ndays.repo.UserJpaRepo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@Api(tags = {"1. User"})
@Tag(name="users", description = "userapi")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class UserController {

    private final UserJpaRepo userJpaRepo;

    @Operation(summary  = "회원 조회", description = "모든 회원을 조회한다",tags={"user"})
    @GetMapping(value = "/users")
    public List<Users> findAllUser() {
        return userJpaRepo.findAll();
    }

    @Operation(summary  = "회원 입력", description = "회원을 입력한다.")
    @PostMapping(value = "/user")
    public Users save(@Parameter(description = "회원아이디", required = true) @RequestParam(value="page", defaultValue="1") String uid,
                     @Parameter(description = "회원이름", required = true) @RequestParam String name) {
        Users user = Users.builder()
                .uid(uid)
                .name(name)
                .build();
        return userJpaRepo.save(user);
    }
}