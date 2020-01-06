package com.maxhyeon.ndays.v1;

import com.maxhyeon.ndays.entity.Users;
import com.maxhyeon.ndays.model.response.CommonResult;
import com.maxhyeon.ndays.model.response.ListResult;
import com.maxhyeon.ndays.model.response.SingleResult;
import com.maxhyeon.ndays.repo.UserJpaRepo;

import com.maxhyeon.ndays.service.ResponseService;
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

    private final ResponseService responseService; // 결과를 처리할 Service
    @Operation(summary  = "회원 리스트 조회", description = "모든 회원을 조회한다",tags={"user"})
    @GetMapping(value = "/users")
    public ListResult<Users> findAllUser() {
        // 결과데이터가 여러건인경우 getListResult를 이용해서 결과를 출력한다.
        return responseService.getListResult(userJpaRepo.findAll());
    }
    @Operation(summary  = "회원 조회", description = "userID회원조회",tags={"user"})
    @GetMapping(value = "/user/{msrl}")
    public SingleResult<Users> findUserById(@Parameter(description = "회원ID", required = true) @PathVariable long msrl) {
        // 결과데이터가 단일건인경우 getBasicResult를 이용해서 결과를 출력한다.
        return responseService.getSingleResult(userJpaRepo.findById(msrl).orElse(null));
    }

    @Operation(summary  = "회원 입력", description = "회원을 입력한다.")
    @PostMapping(value = "/user")
    public SingleResult<Users> save(@Parameter(description = "회원아이디", required = true) @RequestParam(value="page", defaultValue="1") String uid,
                     @Parameter(description = "회원이름", required = true) @RequestParam String name) {
        Users users = Users.builder()
                .uid(uid)
                .name(name)
                .build();
        return responseService.getSingleResult(userJpaRepo.save(users));
    }
    @Operation(summary  = "회원 수정", description = "회원을 수정한다.")
    @PutMapping(value = "/user")
    public SingleResult<Users> modify(
                      @Parameter(description = "회원번호", required = true) @RequestParam(value="page", defaultValue="1") long msrl,
                      @Parameter(description = "회원ID", required = true) @RequestParam String uid,
                      @Parameter(description = "회원이름", required = true) @RequestParam String name){
        Users users = Users.builder()
                .msrl(msrl)
                .uid(uid)
                .name(name)
                .build();
        return responseService.getSingleResult(userJpaRepo.save(users));
    }
    @Operation(summary  = "회원 삭제", description = "회원번호로 회원을 삭제한다.")
    @DeleteMapping(value = "/user/{msrl}")
    public CommonResult delete(@Parameter(description = "회원번호", required = true) @PathVariable(value = "1") long msrl) {
        userJpaRepo.deleteById(msrl);
        return responseService.getSuccessResult();
    }
}