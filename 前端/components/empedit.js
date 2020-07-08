var empedit_template = `
  <div>
    <head1></head1>
      <div class="row">
      <div class="col-md-2 bg-light text-center">
        <br>
        <side :item="2"></side>
      </div>
      <div class="col-md-10">

        <form>

        <table class="table border-0">
        <tr>
            <td class="border-0">
                <div class="form-group form-inline">
                    <label for="id" class="control-label">用户编号：</label>
                    <input type="text" v-bind:readOnly="edit" v-model="customer.id" class="form-control" id="id" placeholder="必须填写">
                </div>
            </td>
            <td  class="border-0">
                <div class="form-group form-inline">
                    <label for="cocah_id" class="control-label">教练名：</label>
                    <select v-model="condition.cocah" class="form-control" id="cocah">
                        <option value="">请选择教练</option>
                        <option v-for="o in cocahs" v-bind:value="o.id">{{o.name}}</option>
                    </select>
                </div>
            </td>
            <td  class="border-0">
                <div class="form-group form-inline">
                    <label for="name" class="control-label">姓名：</label>
                    <input type="text" v-model="customer.name" class="form-control" id="name" placeholder="必须填写">
                </div>
            </td>
        </tr>
    
        <tr>
            <td  class="border-0">
                <div class="form-group form-inline">
                    <label for="phone" class="control-label">手机：</label>
                    <input type="text" v-model="customer.phone" class="form-control" id="phone" placeholder="必须填写">
                </div>
            </td>
            <td  class="border-0">
                <div class="form-group form-inline">
                    <label for="email" class="control-label">邮箱：</label>
                    <input type="text" v-model="customer.email" class="form-control" id="email" placeholder="">
                </div>
            </td>
            <td  class="border-0">
                <div class="form-group form-inline">
                    <label for="sex" class="control-label">性别：</label>
                    <select v-model="customer.sex" class="form-control" id="sex">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>&nbsp;&nbsp;
                </div>
            </td>
        </tr>
    
        <tr>
            <td  class="border-0">
                <div class="form-group form-inline">
                    <label for="sex" class="control-label">级别：</label>
                    <select v-model="customer.party" class="form-control" id="party">
                        <option value="会员">会员</option>
                        <option value="普通用户">普通用户</option>
                        <option value="超级会员">超级会员</option>
                    </select>&nbsp;&nbsp;
                </div>
            </td>
            <td  class="border-0">
                <div class="form-group form-inline">
                   <label for="birthday" class="control-label">生日：</label>
                    <input type="date" v-model="customer.birthday" class="form-control" id="birthday" placeholder="">
                </div>
            </td>
            <td class="border-0">
                <div class="form-group form-inline">
                    <label for="remark" class="control-label">备注：</label>
                    <input type="text" v-model="customer.remark" class="form-control" id="remark" placeholder="">&nbsp;&nbsp;
               </div>
            </td>
        </tr>
        <tr>
            <td  class="border-0">
                <div class="form-group form-inline">
                <label for="birthday" class="control-label">创建时间：</label>
                <input type="date" v-model="customer.create_date" class="form-control" id="create_date" placeholder="">
                </div>
            </td>
            <td class="border-0">
              <button type="submit" v-on:click="add" class="btn btn-primary btn-block">保存</button>
            </td>
            <td class="border-0">
                <h5>{{returnvalue}}</h5>
            </td>
        </tr>
 
    </table>

    </form>
     
    </div>
    </div>
    <foot1></foot1>
  </div>
  `
const empedit = {
    data() {
        return {
            edit: false,
            editid: '',
            shareurl: store.state.url,
            customer: '',
            condition: { name: '', cocah: ''},
            cocahs: [],
            returnvalue: ''
        }
    },
    methods: {
        add() {
            if (this.customer.id == '' || this.customer.name == '' || this.customer.phone == '') {
                alert("必填项不能为空!");
                return;
            };

            //sex字符串处理
            this.customer.sex = String(this.customer.sex);
            //var ejson = JSON.stringify(this.employee);

            if (this.edit) {
                this.$http.put(this.shareurl + 'customer/update', JSON.stringify(this.customer)).then(function (res) {
                    // 这里是处理正确的回调
                    //console.log(response);
                    this.returnvalue = res.body.rows;
                }, function (res) {
                    // 这里是处理错误的回调
                    console.log(res);
                });
            } else {
                this.$http.post(this.shareurl + 'customer/insert', JSON.stringify(this.customer)).then(function (res) {
                    // 这里是处理正确的回调
                    //console.log(response);
                    this.returnvalue = res.body.rows;
                    if (this.returnvalue > 0) {
                        this.customer = { id: '', cocah_id: this.customer.cocah_id, name: '', phone: '', email: '', sex: this.customer.sex, party: '', birthday: '', remark: '', create_date: '' };
                    }
                }, function (res) {
                    // 这里是处理错误的回调
                    alert("用户编号可能重复！");
                    console.log(res);
                });
            }
        },
        select() {
            this.$http.get(this.shareurl + 'customer/select?name=' + this.condition.name + '&cocah=' + this.condition.cocah).then(function (res) {
                // 这里是处理正确的回调
                console.log(response);
                this.customer = res.body
            }, function (res) {
                // 这里是处理错误的回调
                console.log(res)
            });
        },

    },
    mounted: function () {  //这里mounted和created生命周期函数区别
        this.$http.get(this.shareurl + 'cocah/select').then(function (res) {
            // 这里是处理正确的回调
            //console.log(response);
            this.cocahs = res.body
        }, function (res) {
            // 这里是处理错误的回调
            console.log(res)
        });




        //判断是录入新员工，还是编辑已有员工
        if (this.$route.query.id == '' || this.$route.query.id == null) {
            this.edit = false;
            this.customer = { id: '', cocah_id: '', name: '', phone: '', email: '', sex: '男', party: '会员', birthday: '2000-09-09', remark: '', create_date: '' };
        } else {
            this.edit = true;
            this.editid = this.$route.query.id;

            //读取id员工信息
            this.$http.get(this.shareurl + 'customer/selectone/' + this.editid).then(function (res) {
                // 这里是处理正确的回调
                //console.log(response);
                this.customer = res.body;
                console.log(this.customer);
            }, function (res) {
                // 这里是处理错误的回调
                console.log(res)
            });
        }


    },
    template: empedit_template
}
