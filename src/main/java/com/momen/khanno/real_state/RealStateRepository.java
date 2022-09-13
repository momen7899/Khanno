package com.momen.khanno.real_state;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealStateRepository extends PagingAndSortingRepository<RealState, Long> {
    @NotNull
    Page<RealState> findAll(@NotNull Pageable pageable);
}
