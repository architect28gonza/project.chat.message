import Database from "@ioc:Adonis/Lucid/Database";

export class saveMessageImpl implements IsaveMessage {

    async save(body: any): Promise<void> {
        // await Database
        //     .table('tbl_message')
        //     // .returning('id')
        //     .insert(body)
    }
}