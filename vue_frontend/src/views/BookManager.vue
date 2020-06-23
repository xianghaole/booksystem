<template>
    <div>
        <el-table
                :data="tableData"
                border
                style="width: 100%">

            <!--<el-table-column-->
                    <!--type="index"-->
                    <!--label="序号"-->
                    <!--minWidth="150">-->

            <!--</el-table-column>-->
            <el-table-column

                    prop="id"
                    label="编号"
                    minWidth="150">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="图书名"
                    minWidth="120">
            </el-table-column>
            <el-table-column
                    prop="author"
                    label="作者"
                    minWidth="120">
            </el-table-column>


            <el-table-column

                    label="操作"
                    minWidth="100">
                <template slot-scope="scope">
                    <el-button @click="edit(scope.row)" type="primary" size="small">修改</el-button>
                    <el-button type="danger" size="small" @click="del(scope.row)" >删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <!--分页条-->
        <el-pagination style="margin:20px 420px;"
                background
                layout="prev, pager, next"
                :page-size="pageSize"
                :total="total" @current-change="page">
        </el-pagination>

    </div>
</template>

<script>
    import axios from 'axios'
    export default {
        inject:['reload'],
        methods: {
            edit(row) {

                this.$router.push({
                    path:'/UpdateBook',
                    query:{
                        id:row.id
                    }
                })

            },
            del(row){
                axios.delete("http://121.41.97.153:8888/book/delete/"+row.id).then((res)=>{
                    this.$message({
                        message: '恭喜你，删除成功',
                        type: 'success'
                    });
//                    this.$router.push('/')
//                    window.location.reload()
                    this.reload()
                })
            },
            page(currentPage){
                axios.get("http://121.41.97.153:8888/book/findAll/"+(currentPage-1)+"/5").then((res)=>{
                    this.tableData =  res.data.data.content
                    this.pageSize = res.data.data.size

                    this.total= res.data.data.totalElements

                })
            }
        },

        data() {
            return {
                pageSize:5,
                total:0,
                tableData: []
            }
        },
        created(){
            axios.get("http://121.41.97.153:8888/book/findAll/0/5").then((res)=>{
                this.tableData =  res.data.data.content
                this.pageSize = res.data.data.size
                this.total= res.data.data.totalElements
            })
        }
    }
</script>

<style>

</style>
