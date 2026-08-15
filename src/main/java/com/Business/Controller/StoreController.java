package com.Business.Controller;

import com.Business.Execptions.UserException;
import com.Business.Mapper.StoreMapper;
import com.Business.Model.User;
import com.Business.PayLoad.Dto.StoreDTO;
import com.Business.Service.StoreService;
import com.Business.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stores")
public class StoreController {

    private final StoreService storeService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<StoreDTO> createStore(@RequestBody StoreDTO storeDTO,
                                                @RequestHeader("Authorization")
                                                String jwt) throws UserException {
        User user = userService.getUserFromJwtToken(jwt);
        return ResponseEntity.ok(storeService.createStore(storeDTO, user));
    }

    @GetMapping()
    public ResponseEntity<List<StoreDTO>> getAllStore(
            @RequestHeader("Authorization") String jwt) throws Exception {
        return ResponseEntity.ok(storeService.getAllStore());
    }
}
