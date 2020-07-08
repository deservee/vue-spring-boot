var appa_template = `
<div>
    <head1></head1>
        <div class="row">
            <div class="col-md-2 bg-light text-center">
                <br>
                <side :item="3"></side>
            </div>
            <div class="col-md-10">
               
            <table class="table table-bordered table-striped text-center" style="margin-top:20px;">
            <thead>
                <tr>
                    <td>器材编号</td>
                    <td>器材名称</td>
                    <td>购买方</td>
                    <td>型号</td>
                    <td>价格</td>
                    <td>创建时间</td>
                    <td>备注</td>
                    <td colspan="2">操作</td>
                </tr>
            </thead>
            <tr>
                <td><input v-bind:readOnly="isedit" type="text" v-model="rowtp.id" class="form-control" placeholder="">
                </td>
                <td><input type="text" v-model="rowtp.name" class="form-control" placeholder=""></td>
                <td><input type="text" v-model="rowtp.mill" class="form-control" placeholder=""></td>
                <td><input type="text" v-model="rowtp.model" class="form-control" placeholder=""></td>
                <td><input type="text" v-model="rowtp.price" class="form-control" placeholder=""></td>
                <td><input type="text" v-model="rowtp.createdate" class="form-control" placeholder=""></td>
                <td><input type="text" v-model="rowtp.remark" class="form-control" placeholder=""></td>
                <td><button type="button" class="btn btn-primary" v-on:click="Save()">保存</button></td>
                <td><button type="button" class="btn btn-primary" v-on:click="Clear()">放弃</button></td>
            </tr>
            <tr v-for="(row,index) in appas">
                <td>{{ row.id}}</td>
                <td>{{ row.name}}</td>
                <td>{{ row.mill}}</td>
                <td>{{ row.model}}</td>
                <td>{{ row.price}}</td>
                <td>{{ row.createdate}}</td>
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
const appa = {
    data() {
        return {
            appas: [],
            shareurl: store.state.url,
            rowtp: { id: '', name: '', mill: '', model: '', price: '', createdate: '', remark: '' },
            isedit: false
        }
    },

    mounted: function () {
        //发送get请求
        this.$http.get(this.shareurl + 'appa/select').then(function (res) {
            this.appas = res.body;
        }, function () {
            alert('请求失败');
        });
    },
    methods: {
        Save() {
            if (this.rowtp.id == '' || this.rowtp.name == '') {
                alert("器械编号、名称不能为空!");
                return;
            }
            var temp = this.rowtp;
            if (this.isedit == false) {
                //增加数据库
                this.$http.post(this.shareurl + 'appa/insert', { id: temp.id, name: temp.name, mill: temp.mill, model: temp.model, price: temp.price, createdate: temp.createdate, remark: temp.remark } ).then(function (res) {
                    //console.log(res);
                    if (res.body.rows > 0) {
                        this.appas.push(temp);
                    }
                }, function (res) {
                    // 这里是处理错误的回调
                    //console.log(res)
                });

            } else {
                //修改数据库
                this.$http.put(this.shareurl + 'appa/update', { id: temp.id, name: temp.name, mill: temp.mill, model: temp.model, price: temp.price, createdate: temp.createdate, remark: temp.remark } ).then(function (res) {
                    //console.log(res);
                    if (res.body.rows > 0) {
                        for (var i = 0; i < this.appas.length; i++) {
                            if (this.appas[i].id == temp.id) {
                                this.appas[i].name = temp.name;
                                this.appas[i].mill = temp.mill;
                                this.appas[i].model = temp.model;
                                this.appas[i].price = temp.price;
                                this.appas[i].createdate = temp.createdate;
                                this.appas[i].remark = temp.remark;
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
            this.$http.delete(this.shareurl + 'appa/delete/'+this.appas[index].id ).then(function (res) {
                if (res.body.rows > 0) {
                    this.appas.splice(index, 1);//从下标i开始删除1个元素：删除下标为i的元素
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
            this.rowtp.mill = row.mill;
            this.rowtp.model = row.model;
            this.rowtp.price = row.price;
            this.rowtp.createdate = row.createdate;
            this.rowtp.remark = row.remark;
            this.isedit = true;
        },
        Clear() {
            this.rowtp = {  id: '', name: '', mill: '', model: '', price: '', createdate: '', remark: '' };
            this.isedit = false;
        }

    },
    template: appa_template
}
