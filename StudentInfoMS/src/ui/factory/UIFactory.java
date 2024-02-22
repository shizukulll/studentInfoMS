package ui.factory;

public class UIFactory {
    public static UIFrame createFrame(Class<? extends UIFrame> frameClass) {
        try {
            return frameClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}