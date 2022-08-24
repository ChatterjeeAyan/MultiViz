/*
Copyright 2008 WebAtlas
Authors : Mathieu Bastian, Mathieu Jacomy, Julian Bilcke
Website : http://www.gephi.org

This file is part of Gephi.

Gephi is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Gephi is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Gephi.  If not, see <http://www.gnu.org/licenses/>.
 */
package helpers;

import java.beans.PropertyEditorSupport;
import multiviz.MultiLayerVisualization;

/**
 *
 * @author J
 */
public abstract class ColumnDropDownProperty extends PropertyEditorSupport {

    private String[] listOfColumns = {"Node Label", "Edge Label"};
    private String selectedColumn;
    
    protected ColumnDropDownProperty(){}

    @Override
    public String[] getTags() {
        if(MultiLayerVisualization.selectableColumns.isEmpty()){
            return listOfColumns;
        } else {
            return MultiLayerVisualization.selectableColumns.toArray(String[]::new);
        }
    }

    @Override
    public Object getValue() {
        return selectedColumn;
    }

    @Override
    public void setValue(Object value) {
        if(MultiLayerVisualization.selectableColumns.isEmpty()){
            for (String column : listOfColumns) {
                if(column.equals((String)value)){
                    selectedColumn = column;
                    break;
                }
            }
        } else {
            for (String column : MultiLayerVisualization.selectableColumns) {
                if(column.equals((String) value)) {
                    selectedColumn = column;
                    break;
                }
            }
        }
    }

    @Override
    public String getAsText() {
        return getValue().toString();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(text);
    }    
    
}
