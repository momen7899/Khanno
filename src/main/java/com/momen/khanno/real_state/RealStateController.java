package com.momen.khanno.real_state;

import com.momen.khanno.common.PagingData;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/v1/realState")
public class RealStateController {
    private final RealStateService service;
    private final RealStateMapper mapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody RealStateDTO realStateDTO) {
        RealState realState = mapper.toRealState(realStateDTO);
        service.save(realState);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<RealStateDTO> update(@RequestBody RealStateDTO realStateDTO) {
        RealState realState = mapper.toRealState(realStateDTO);
        RealStateDTO savedBefore = mapper.toRealStateDTO(service.update(realState));
        return ResponseEntity.ok(savedBefore);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/paging/{page}/{count}")
    public ResponseEntity<PagingData<RealStateDTO>> pagination(@PathVariable Integer page, @PathVariable Integer count) {
        Page<RealState> realStates = service.getRealStates(page, count);

        int totalPage = realStates.getTotalPages();
        List<RealStateDTO> cities = mapper.toRealStateDTOS(realStates.getContent());

        PagingData<RealStateDTO> pagingData = new PagingData<>(totalPage, page, cities);

        return ResponseEntity.ok(pagingData);
    }
}