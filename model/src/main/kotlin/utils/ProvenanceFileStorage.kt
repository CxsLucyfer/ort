/*
 * Copyright (C) 2021 The ORT Project Authors (see <https://github.com/oss-review-toolkit/ort/blob/main/NOTICE>)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 * License-Filename: LICENSE
 */
package org.ossreviewtoolkit.model.utils

import java.io.File

import org.ossreviewtoolkit.model.KnownProvenance

/**
 * A storage which associates a file with a [KnownProvenance]
 */
interface ProvenanceFileStorage {
    /**
     * Return whether a file corresponding to [provenance] exists.
     */
    fun hasFile(provenance: KnownProvenance): Boolean

    /**
     * Associate the [file] to [provenance]. Overwrites any existing file corresponding to [provenance].
     */
    fun putFile(provenance: KnownProvenance, file: File)

    /**
     * Return the file corresponding to [provenance] or null if no such file exists. The returned file is a
     * temporary file.
     */
    fun getFile(provenance: KnownProvenance): File?
}
