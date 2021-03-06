﻿var user_template = `
<div>
    <head1></head1>
        <div class="row">
            <div class="col-md-2 bg-light text-center">
                <br>
                <side :item="7"></side>
            </div>
            <div class="col-md-10">
               
            <table class="table table-bordered table-striped text-center" style="margin-top:20px;">
            <thead>
                <tr>
                    <td>职工编号</td>
                    <td>登录名称</td>
                    <td>密码</td>
                    <td>政治面貌</td>
                    <td>入职日期</td>
                    <td>用户名</td>
                    <td colspan="2">操作</td>
                </tr>
            </thead>
            <tr>
                <td><input v-bind:readOnly="isedit" type="text" v-model="rowtp.id" class="form-control" placeholder="">
                </td>
                <td><input type="text" v-model="rowtp.loginname" class="form-control" placeholder=""></td>
                <td><input type="text" v-model="rowtp.password" class="form-control" placeholder=""></td>
                <td><input type="text" v-model="rowtp.status" class="form-control" placeholder=""></td>
                <td><input type="text" v-model="rowtp.createdate" class="form-control" placeholder=""></td>
                <td><input type="text" v-model="rowtp.username" class="form-control" placeholder=""></td>
                <td><button type="button" class="btn btn-primary" v-on:click="Save()">保存</button></td>
                <td><button type="button" class="btn btn-primary" v-on:click="Clear()">放弃</button></td>
            </tr>
            <tr v-for="(row,index) in users">

                <td>{{ row.id}}</td>
                <td>{{ row.loginname}}</td>
                <td>{{ row.password}}</td>
                <td>{{ row.status}}</td>
                <td>{{ row.createdate}}</td>
                <td>{{ row.username}}</td>
                <td><button type="button" class="btn btn-outline-primary" v-on:click="Edit(row)">编辑</button></td>
                <td><button type="button" class="btn btn-outline-primary" v-on:click="Delete(index)">删除</button></td>
            </tr>

        </table>

            </div>
        </div>
    <foot1></foot1>
</div>
        `
const user = {
    data() {
        return {
            users: [],
            shareurl: store.state.url,
            rowtp: { id: '', name: '', remark: '' },
            isedit: false
        }
    },

    mounted: function () {
        //发送get请求
        this.$http.get(this.shareurl + 'user/select').then(function (res) {
            this.users = res.body;
        }, function () {
            alert('请求失败');
        });
    },
    methods: {
        Save() {
            if (this.rowtp.id == '' || this.rowtp.name == '') {
                alert("职工编号、名称不能为空!");
                return;
            }
            var temp = this.rowtp;
            if (this.isedit == false) {
                //增加数据库
                this.$http.post(this.shareurl + 'user/insert', { id: temp.id, loginname: temp.loginname, password: temp.password, status: temp.status, createdate: temp.createdate, username: temp.username } ).then(function (res) {
                    //console.log(res);
                    if (res.body.rows > 0) {
                        this.users.push(temp);
                    }
                }, function (res) {
                    // 这里是处理错误的回调
                    //console.log(res)
                });

            } else {
                //修改数据库
                this.$http.put(this.shareurl + 'user/update', { id: temp.id, loginname: temp.loginname, password: temp.password, status: temp.status, createdate: temp.createdate, username: temp.username } ).then(function (res) {
                    //console.log(res);
                    if (res.body.rows > 0) {
                        for (var i = 0; i < this.users.length; i++) {
                            if (this.users[i].id == temp.id) {
                                this.users[i].loginname = temp.loginname;
                                this.users[i].password = temp.password;
                                this.users[i].status = temp.status;
                                this.users[i].createdate = temp.createdate;
                                this.users[i].username = temp.username;
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
            this.$http.delete(this.shareurl + 'user/delete/'+this.users[index].id ).then(function (res) {
                if (res.body.rows > 0) {
                    this.users.splice(index, 1);//从下标i开始删除1个元素：删除下标为i的元素
                    this.Clear();
                }
            }, function (res) {
                // 这里是处理错误的回调
                console.log(res)
            });
        },
        Edit(row) {
            this.users[i].id == temp.id;
            this.users[i].loginname = temp.loginname;
            this.users[i].password = temp.password;
            this.users[i].status = temp.status;
            this.users[i].createdate = temp.createdate;
            this.users[i].username = temp.username;
            this.isedit = true;
        },
        Clear() {
            this.rowtp = {  id: '', loginname: '', password:'', status:'', createdate:'', username: '' };
            this.isedit = false;
        }

    },
    template: user_template
}
