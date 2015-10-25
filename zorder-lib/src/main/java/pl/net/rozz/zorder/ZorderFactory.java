package pl.net.rozz.zorder;

import static com.google.common.base.Preconditions.checkArgument;

public class ZorderFactory {

    private static ZorderFactory instance = new ZorderFactory();

    public static ZorderFactory getInstance() {
        return instance;
    }

    public <T> Zorder<T> getNDimensionalFunction(final int dimensions, final Class<T> clazz) {
        checkArgument(dimensions==2, "Only 2 dimensions are supported now");

        return new Zorder2dImpl<T>();
    }

}
