export class Form {

    zipCode: string ="";
    distance: number = 0;

    public constructor(init?: Partial<Form>) {
        Object.assign(this, init);
    }
    
}
