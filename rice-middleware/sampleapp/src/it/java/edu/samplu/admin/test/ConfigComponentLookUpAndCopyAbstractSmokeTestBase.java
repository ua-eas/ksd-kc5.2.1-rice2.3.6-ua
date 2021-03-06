/**
 * Copyright 2005-2013 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ecl2.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.samplu.admin.test;

import edu.samplu.common.Failable;
import edu.samplu.common.ITUtil;
import org.apache.commons.lang.RandomStringUtils;

/**
 * @author Kuali Rice Team (rice.collab@kuali.org)
 */
public abstract class ConfigComponentLookUpAndCopyAbstractSmokeTestBase extends AdminTmplMthdSTNavBase{

    /**
     * ITUtil.PORTAL+"?channelTitle=Component&channelUrl="+ITUtil.getBaseUrlString()+
     * "/kr/lookup.do?methodToCall=start&businessObjectClassName=org.kuali.rice.coreservice.impl.component.ComponentBo&docFormKey=88888888&returnLocation="+
     * +ITUtil.PORTAL_URL+ ITUtil.HIDE_RETURN_LINK;
     */    
    public static final String BOOKMARK_URL = ITUtil.PORTAL+"?channelTitle=Component&channelUrl="+ITUtil.getBaseUrlString()+
            "/kr/lookup.do?methodToCall=start&businessObjectClassName=org.kuali.rice.coreservice.impl.component.ComponentBo&docFormKey=88888888&returnLocation="+
            ITUtil.PORTAL_URL+ ITUtil.HIDE_RETURN_LINK;

    /**
     * {@inheritDoc}
     * Component
     * @return
     */
    @Override
    protected String getLinkLocator() {
        return "Component";
    }

    public void testConfigComponentLookUpAndCopyBookmark(Failable failable) throws Exception {
        testConfigComponentLookUpAndCopy();
        passed();
    }

    public void testConfigComponentLookUpAndCopyNav(Failable failable) throws Exception {
        testConfigComponentLookUpAndCopy();
        passed();
    }    
    
    public void testConfigComponentLookUpAndCopy() throws Exception
    {
        selectFrameIframePortlet();
        waitAndClickByXpath("(//input[@name='methodToCall.search'])[2]");
        waitAndClickByLinkText("copy");
        String fourLetters = RandomStringUtils.randomAlphabetic(4);
        waitAndTypeByName("document.documentHeader.documentDescription","Test description of Component copy " + ITUtil.createUniqueDtsPlusTwoRandomCharsNot9Digits());
        selectByName("document.newMaintainableObject.namespaceCode","KR-WKFLW - Workflow");
        waitAndTypeByName("document.newMaintainableObject.code","ActionList2" + fourLetters);
        waitAndTypeByName("document.newMaintainableObject.name",fourLetters);
        waitAndTypeByName("document.newMaintainableObject.name","Action List 2 " + fourLetters);
        waitAndClickByName("methodToCall.route");
        checkForDocError();
        waitAndClickByName("methodToCall.close");
        waitAndClickByName("methodToCall.processAnswer.button1");
    }
}
