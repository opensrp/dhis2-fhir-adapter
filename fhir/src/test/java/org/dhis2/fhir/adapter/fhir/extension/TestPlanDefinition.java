package org.dhis2.fhir.adapter.fhir.extension;

/*
 * Copyright (c) 2004-2019, University of Oslo
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * Neither the name of the HISP project nor the names of its contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import ca.uhn.fhir.model.api.ExtensionDt;
import org.hl7.fhir.instance.model.api.IBaseExtension;
import org.hl7.fhir.instance.model.api.IBaseHasExtensions;

import java.util.ArrayList;
import java.util.List;

/**
 * Test plan definition FHIR resource.
 *
 * @author volsch
 */
class TestPlanDefinition implements IBaseHasExtensions
{
    private final List<IBaseExtension<?, ?>> extensions = new ArrayList<>();

    @Override
    public IBaseExtension<?, ?> addExtension()
    {
        extensions.add( new ExtensionDt() );

        return extensions.get( extensions.size() - 1 );
    }

    @Override
    public List<? extends IBaseExtension<?, ?>> getExtension()
    {
        return extensions;
    }

    @Override
    public boolean hasExtension()
    {
        return !extensions.isEmpty();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean hasFormatComment() {
        return false;
    }

    @Override
    public List<String> getFormatCommentsPre() {
        return null;
    }

    @Override
    public List<String> getFormatCommentsPost() {
        return null;
    }

    @Override
    public Object getUserData(String s) {
        return null;
    }

    @Override
    public void setUserData(String s, Object o) {

    }
}
