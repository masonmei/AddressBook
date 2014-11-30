package org.personal.mason.common.code.gen.project;

import org.personal.mason.common.code.util.Assert;
import org.personal.mason.common.code.util.Utils;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by m00290368 on 2014-11-27.
 */
public abstract class AbstractProjectStructure<T> implements ProjectStructure<T> {

    private static final long MIN_PROJECT_SPACE_IN_MB = 500 * 1024 * 1024;

    private final String name;
    private final String description;
    private final File path;
    private final Set<T> elements;

    private File currentPath;

    public AbstractProjectStructure(String name, String description, File path) {
        Assert.hasLength(name, "Project Name Must has length.");
        path = Utils.toCanonicalFile(path);
        Assert.notNull(path, "Project Base Path must not be null.");
        validatePath(path);
        this.currentPath = Utils.getChildFile(path, name);
        this.name = name;
        this.description = description == null ? "" : description;
        this.path = path;
        this.elements = new HashSet<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public File getBasePath() {
        return path;
    }

    private void validatePath(File projectPathFile) {

        if (!projectPathFile.isDirectory()) {
            throw new IllegalStateException("Project must be created in a directory. ");
        }

        if (projectPathFile.isHidden()) {
            throw new IllegalStateException("Project cannot be created in hidden directory.");
        }

        if (!projectPathFile.canWrite()) {
            throw new IllegalStateException("Project must be generated in a writable directory.");
        }

        if (projectPathFile.getUsableSpace() < MIN_PROJECT_SPACE_IN_MB) {
            throw new IllegalStateException("No Enough disk space for generate project, the minimum space required is 500M.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractProjectStructure)) return false;

        AbstractProjectStructure that = (AbstractProjectStructure) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (path != null ? !path.equals(that.path) : that.path != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (path != null ? path.hashCode() : 0);
        return result;
    }

    @Override
    public File getCurrentDirectory() {
        return currentPath;
    }

    @Override
    public Set<T> getSubElements() {
        return Collections.unmodifiableSet(elements);
    }

    @Override
    public void addSubElement(T... elements) {
        if (elements != null) {
            this.elements.addAll(Arrays.asList(elements));
        }
    }
}
