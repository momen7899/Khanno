package com.momen.khanno.real_state;

import org.springframework.data.domain.Page;

public interface RealStateService {
    RealState save(RealState realState);

    RealState update(RealState realState);

    RealState getById(long id);

    void delete(Long id);

    Page<RealState> getRealStates(Integer page, Integer count);

}
