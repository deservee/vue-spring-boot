var cocah_template = `
<div>
    <head1></head1>
        <div class="row">
            <div class="col-md-2 bg-light text-center">
                <br>
                <side :item="5"></side>
            </div>
            <div class="col-md-10">
               
            <table class="table table-bordered table-striped text-center" style="margin-top:20px;">
            <thead>
                <tr>
                    <td>教练编号</td>
                    <td>教练名称</td>
                    <td>联系方式</td>
                    <td>创建时间</td>
                    <td>email</td>
                    <td>性别</td>
                    <td>教练职称</td>
                    <td>生日</td>
                    <td>备注</td>
                    <td colspan="2">操作</td>
                </tr>
            </thead>
            <tr>
                <td><input v-bind:readOnly="isedit" type="text" v-model="rowtp.id" class="form-control" placeholder="">
                </td>
                <td><input type="text" v-model="rowtp.name" class="form-control" placeholder=""></td>
                <td><input type="text" v-model="rowtp.phone" class="form-control" placeholder=""></td>
                <td><input type="text" v-model="rowtp.createdate" class="form-control" placeholder=""></td>
                <td><input type="text" v-model="rowtp.email" class="form-control" placeholder=""></td>
                <td><input type="text" v-model="rowtp.sex" class="form-control" placeholder=""></td>
                <td><input type="text" v-model="rowtp.party" class="form-control" placeholder=""></td>
                <td><input type="text" v-model="rowtp.birthday" class="form-control" placeholder=""></td>
                <td><input type="text" v-model="rowtp.remark" class="form-control" placeholder=""></td>
                <td><button type="button" class="btn btn-primary" v-on:click="Save()">保存</button></td>
                <td><button type="button" class="btn btn-primary" v-on:click="Clear()">放弃</button></td>
            </tr>
            <tr v-for="(row,index) in cocahs">
                <td>{{ row.id}}</td>
                <td>{{ row.name}}</td>
                <td>{{ row.phone}}</td>
                <td>{{ row.createdate}}</td>
                <td>{{ row.email}}</td>
                <td>{{ row.sex}}</td>
                <td>{{ row.party}}</td>
                <td>{{ row.birthday}}</td>
                <td>{{ row.remark}}</td>
                <td><button type="button" class="btn btn-outline-primary" v-on:click="Edit(row)">编辑</button></td>
                <td><button type="button" class="btn btn-outline-primary" v-on:click="Delete(index)">删除</button></td>
            </tr>

        </table>

            </div>
        </div>
    <foot1></foot1>
</div>
        `
const cocah = {
    data() {
        return {
            cocahs: [],
            shareurl: store.state.url,
            rowtp: { id: '', name: '', phone: '', createdate: '', email: '', sex: '', party: '', birthday: '', remark: '' },
            isedit: false
        }
    },

    mounted: function () {
        //发送get请求
        this.$http.get(this.shareurl + 'cocah/select').then(function (res) {
            this.cocahs = res.body;
        }, function () {
            alert('请求失败');
        });
    },
    methods: {
        Save() {
            if (this.rowtp.id == '' || this.rowtp.name == '') {
                alert("教练编号、名称不能为空!");
                return;
            }
            var temp = this.rowtp;
            if (this.isedit == false) {
                //增加数据库
                this.$http.post(this.shareurl + 'cocah/insert', { id: temp.id, name: temp.name, phone: temp.phone, createdate: temp.createdate, email: temp.email, sex: temp.sex, party: temp.party, birthday: temp.birthday, remark: temp.remark } ).then(function (res) {
                    //console.log(res);
                    if (res.body.rows > 0) {
                        this.cocahs.push(temp);
                    }
                }, function (res) {
                    // 这里是处理错误的回调
                    //console.log(res)
                });

            } else {
                //修改数据库
                this.$http.put(this.shareurl + 'cocah/update', { id: temp.id, name: temp.name, phone: temp.phone, createdate: temp.createdate, email: temp.email, sex: temp.sex, party: temp.party, birthday: temp.birthday, remark: temp.remark } ).then(function (res) {
                    //console.log(res);
                    if (res.body.rows > 0) {
                        for (var i = 0; i < this.cocahs.length; i++) {
                            if (this.cocahs[i].id == temp.id) {
                                this.cocahs[i].name = temp.name;
                                this.cocahs[i].phone = temp.phone;
                                this.cocahs[i].createdate = temp.createdate;
                                this.cocahs[i].email = temp.email;
                                this.cocahs[i].sex = temp.sex;
                                this.cocahs[i].party = temp.party;
                                this.cocahs[i].birthday = temp.birthday;
                                this.cocahs[i].remark = temp.remark;
                                break;
                            }
                        };
                    }
                }, function (res) {
                    // 这里是处理错误的回调
                    console.log(res)
                });

            }
            //还原模板
            this.Clear();
            this.isedit = false;
        },
        Delete(index) {
            //数据库操作
            this.$http.delete(this.shareurl + 'cocah/delete/'+this.cocahs[index].id ).then(function (res) {
                if (res.body.rows > 0) {
                    this.cocahs.splice(index, 1);//从下标i开始删除1个元素：删除下标为i的元素
                    this.Clear();
                }
            }, function (res) {
                // 这里是处理错误的回调
                console.log(res)
            });
        },
        Edit(row) {
            this.rowtp.id = row.id;
            this.rowtp.name = row.name;
            this.rowtp.phone = row.phone;
            this.rowtp.createdate = row.createdate;
            this.rowtp.email = row.email;
            this.rowtp.sex = row.sex;
            this.rowtp.party = row.party;
            this.rowtp.birthday = row.birthday;
            this.rowtp.remark = row.remark;
            this.isedit = true;
        },
        Clear() {
            this.rowtp = {  id: '', name: '', phone: '', createdate: '', email: '', sex: '', party: '', birthday: '', remark: '' };
            this.isedit = false;
        }

    },
    template: cocah_template
}
