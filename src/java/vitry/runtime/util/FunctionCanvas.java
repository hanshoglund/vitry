package vitry.runtime.util;

import java.awt.Canvas;
import java.awt.Graphics;

import vitry.runtime.Function;

public class FunctionCanvas extends Canvas
{
    private static final long serialVersionUID = -6576900269885764409L;
    private final Function painter;

    public FunctionCanvas(Function painter) {
        this.painter = painter;
    }

    public void paint(Graphics g)
    {
        painter.apply(g);
    }
}
