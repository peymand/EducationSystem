package aero.mahan.view.interfaces;

import aero.mahan.model.Semester;

/**
 * Created by airin.khorsandmahand on 2/28/2016.
 */
public interface IEventTableNotifier<T> {

    void rowSelectionEventOccured(T value1, int index);
}
