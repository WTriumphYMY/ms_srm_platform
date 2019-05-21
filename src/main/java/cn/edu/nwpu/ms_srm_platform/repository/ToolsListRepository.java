package cn.edu.nwpu.ms_srm_platform.repository;

import cn.edu.nwpu.ms_srm_platform.domain.ToolsList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolsListRepository extends JpaRepository<ToolsList, Integer> {
    ToolsList findByToolAlias(String alias);
}
