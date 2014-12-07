package org.personal.mason.common.code.gen.template.java;

import java.net.URL;
import java.util.Collections;
import java.util.Set;

/**
 * Created by m00290368 on 2014-12-02.
 */
public class CopyrightPart extends AbstractJavaFilePart {
    private final Long copyrightYear;
    private final String copyrightName;
    private final String copyrightLicenseNameAndVersion;
    private final URL copyrightLicenseUri;

    public CopyrightPart(Long copyrightYear, String copyrightName, String copyrightLicenseNameAndVersion, URL copyrightLicenseUri) {
        this.copyrightYear = copyrightYear;
        this.copyrightName = copyrightName;
        this.copyrightLicenseNameAndVersion = copyrightLicenseNameAndVersion;
        this.copyrightLicenseUri = copyrightLicenseUri;
    }

    public Long getCopyrightYear() {
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

    @Override
    public Set<String> getImports() {
        return Collections.emptySet();
    }
}
