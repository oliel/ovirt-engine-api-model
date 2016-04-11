/*
Copyright (c) 2016 Red Hat, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package services;

import org.ovirt.api.metamodel.annotations.In;
import org.ovirt.api.metamodel.annotations.Out;
import org.ovirt.api.metamodel.annotations.Service;
import types.AffinityLabel;

/**
 * Top level affinitylabels collection used to navigate
 * all affinity labels and their assignments.
 */
@Service
public interface AffinityLabelsService {
    /**
     * Creates a new label. The label is automatically attached
     * to all entities mentioned in the vms or hosts lists.
     */
    interface Add {
        @In @Out AffinityLabel label();
    }

    /**
     * Lists all labels present in the system.
     */
    interface List {
        @Out AffinityLabel[] labels();

        /**
         * Sets the maximum number of labels to return. If not specified all the tags are returned.
         */
        @In Integer max();
    }

    /**
     * Link to a single label details.
     */
    @Service AffinityLabelService label(String id);
}
