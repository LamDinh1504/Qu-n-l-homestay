
package bean;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class DanhMucBean {
    private String kind;
    private JPanel jpb;
    private JLabel jlb;

    public DanhMucBean(String kind, JPanel jpb, JLabel jlb) {
        this.kind = kind;
        this.jpb = jpb;
        this.jlb = jlb;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JPanel getJpb() {
        return jpb;
    }

    public void setJpb(JPanel jpb) {
        this.jpb = jpb;
    }

    public JLabel getJlb() {
        return jlb;
    }

    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }

}
