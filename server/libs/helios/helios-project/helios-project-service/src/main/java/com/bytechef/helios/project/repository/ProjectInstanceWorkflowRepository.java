
/*
 * Copyright 2021 <your company/name>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytechef.helios.project.repository;

import com.bytechef.helios.project.domain.ProjectInstanceWorkflow;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ivica Cardic
 */
@Repository
public interface ProjectInstanceWorkflowRepository extends ListCrudRepository<ProjectInstanceWorkflow, Long> {

    List<ProjectInstanceWorkflow> findAllByProjectInstanceId(long projectInstanceId);

    List<ProjectInstanceWorkflow> findAllByProjectInstanceIdIn(List<Long> projectInstanceIds);

    ProjectInstanceWorkflow findByProjectInstanceIdAndWorkflowId(long projectInstanceId, String workflowId);
}
