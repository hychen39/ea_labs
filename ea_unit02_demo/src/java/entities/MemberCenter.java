/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author hychen39@gm.cyut.edu.tw
 * @since Mar 9, 2019
 */
public class MemberCenter {

    static public class Member {

        private String type;
        private float yearFee;
        private String privilege;

        public Member(String type, float yearFee) {
            this.type = type;
            this.yearFee = yearFee;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public float getYearFee() {
            return yearFee;
        }

        public void setYearFee(float yearFee) {
            this.yearFee = yearFee;
        }

        public String getPrivilege() {
            return privilege;
        }

        public void setPrivilege(String privilege) {
            this.privilege = privilege;
        }
    }

    static public Member getGoldMember() {
        Member m;
        m = new Member("GOLD", 10000);
        m.privilege = "機場接送;貴賓室;道路救援; 2%現金回饋";
        return m;
    }

    static public Member getPlatinumMember() {
        Member m = new Member("PLATIUM", 5000);
        m.privilege = "機場接送;貴賓室;道路救援";
        return m;
    }
}
