import { AddComponent } from './add/add.component';
import { WorstComponent } from './worst/worst.component';
import { BestComponent } from './best/best.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import {Routes, RouterModule} from '@angular/router';

const routes: Routes = [
    {
        path: '', redirectTo: 'dashboard', pathMatch: 'full'
    },
    {
        path: 'dashboard', component: DashboardComponent
    },
    {
        path: 'best', component: BestComponent
    },
    {
        path: 'worst', component: WorstComponent
    },
    {
        path: 'add', component: AddComponent
    }
];

export const routing = RouterModule.forRoot(routes);
