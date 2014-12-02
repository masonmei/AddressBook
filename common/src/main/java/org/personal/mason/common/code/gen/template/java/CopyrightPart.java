package org.personal.mason.common.code.gen.template.java;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by m00290368 on 2014-12-02.
 */
public class CopyrightPart extends AbstractJavaFilePart {
    private final Integer copyrightYear;
    private final String copyrightName;
    private final String copyrightLicenseNameAndVersion;
    private final URL copyrightLicenseUri;

    public CopyrightPart(Integer copyrightYear, String copyrightName, String copyrightLicenseNameAndVersion, URL copyrightLicenseUri) {
        this.copyrightYear = copyrightYear;
        this.copyrightName = copyrightName;
        this.copyrightLicenseNameAndVersion = copyrightLicenseNameAndVersion;
        this.copyrightLicenseUri = copyrightLicenseUri;
    }

    public Integer getCopyrightYear() {
        return copyrightYear;
    }

    public String getCopyrightName() {
        return copyrightName;
    }

    public String getCopyrightLicenseNameAndVersion() {
        return copyrightLicenseNameAndVersion;
    }

    public URL getCopyrightLicenseUri() {
        return copyrightLicenseUri;
    }

    @Override
    public String build() {
        return null;
    }

    public static void main(String[] args) {
        try {
            CopyrightPart part = new CopyrightPart(2013, "Apache", "Apache", new URL("http://www.baidu.com"));
            part.setTemplateAttributes();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}